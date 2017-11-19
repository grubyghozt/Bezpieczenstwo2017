package controllers;

import bean.enums.ErrorCode;
import bean.forms.NewUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.SignUpService;

@Controller
public class DefaultController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping("/")
    public String index() {
        return "redirect:sign_in";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String signIn(@RequestParam(name = "error", required = false) Integer errorCode, Model model) {
        if (getPrincipal() == null) {
            if (errorCode != null) {
                model.addAttribute("errorCode", ErrorCode.getCodeByStatus(errorCode));
            }
            return "sign_in";
        } else {
            return "redirect:/my_account/home";
        }
    }

    private String getPrincipal() {
        String userName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }
        return userName;
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String signUp(Model model) {
        model.addAttribute("form", new NewUserForm());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute(name = "form") @Validated NewUserForm newUserForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "sign_up";
        }

        signUpService.addUser(newUserForm);
        return "sign_in";
    }
}
