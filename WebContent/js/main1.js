
(function ($) {
    "use strict";


    /*==================================================================
   [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })
    })


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
            if(validate2(input[i])!=0){
                var userpwd =validate2(input[i]);
                // alert(pass);
            }
            if(validate3(input[i])!=0){
                var pass2 =validate3(input[i]);
                // alert(pass2);
            }
            if(len(input[i])==0){
                alert(len(input[i]));
                showValidate(input[i]);
                check = false;
            }
        }
        if(userpwd!=pass2&&userpwd!=null&&pass2!=null){
            check = false;
            alert("❌ 两次输入的密码不一致,请重新输入")
        }
        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'userphone' || $(input).attr('name') == 'userphone') {
            if($(input).val().trim().match(/^1[0-9]{10}$/) == null) {
                // /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/
                return false;
            }
        }
        if($(input).attr('type') == 'username' || $(input).attr('name') == 'username'){
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function validate2 (input) {
        if( $(input).attr('name') == 'userpwd') {
            return $(input).val().trim();
        }else{
            return 0;
        }
    }
    function validate3 (input) {
        if( $(input).attr('name') == 'pass2') {
            return $(input).val().trim();
        }else{
            return 0;
        }
    }

    function len(input){
        if($(input).attr('name') == 'pass'||$(input).attr('name') == 'pass2'){
            var judge = 0;
            if($(input).val().length<8||$(input).val().length>16){
                judge = 1;
            }else{
                judge = -1;
            }
        }else{
            judge = -2;
        }
        console.log(judge);
        alert(judge);
        return judge;
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
    }

})(jQuery);
