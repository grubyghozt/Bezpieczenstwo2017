package controllers;

import bean.forms.TransferForm;
import bean.model.Transfer;
import bean.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.TransferService;

import java.util.Collection;

@Controller
@RequestMapping(UserController.ROOT_MAPPING)
@PreAuthorize("hasRole('USER')")
public class UserController {

    public static final String ROOT_MAPPING = "/my_account";

    @Autowired
    private TransferService transferService;

    @RequestMapping("/home")
    public String homePage() {
        return "/my_account/home";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transfer(Model model) {
        model.addAttribute("form", new TransferForm());
        return "/my_account/transfer";
    }

    @RequestMapping(value = "/preview_transfer", method = RequestMethod.POST)
    public String previewTransfer(Model model, @ModelAttribute(name = "form") @Validated TransferForm transferForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/my_account/transfer";
        }
        model.addAttribute("form", transferForm);
        return "/my_account/preview_transfer";
    }

    @RequestMapping(value = "/preview_transfer", method = RequestMethod.GET)
    public String previewTransfer() {
        return "redirect:/my_account/transfer";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(@ModelAttribute(name = "form") TransferForm transferForm, RedirectAttributes redirectAttributes) {
        transferService.addTransfer(transferForm);
        redirectAttributes.addFlashAttribute("transferForm", transferForm);
        return "redirect:/my_account/transfer_done";
    }

    @RequestMapping(value = "/transfer_done", method = RequestMethod.GET)
    public String transferDone(@ModelAttribute(name = "transferForm") TransferForm transferForm, Model model) {
        model.addAttribute("transferForm", transferForm);
        return "/my_account/transfer_done";
    }


    @RequestMapping(value = "/my_transfers", method = RequestMethod.GET)
    public String myTransfers(Model model) {
        Collection<Transfer> transfers = transferService.getAllTransfers((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("transfers", transfers);
        return "/my_account/all_transfers";
    }
}
