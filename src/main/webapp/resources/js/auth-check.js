$(document).ready(function(){

    // Устанавливаем обработчик потери фокуса для всех полей ввода текста
    $('input#auth-email, input#auth-password').unbind().blur( function(){

        // Для удобства записываем обращения к атрибуту и значению каждого поля в переменные
        var id = $(this).attr('id');
        var val = $(this).val();

        // После того, как поле потеряло фокус, перебираем значения id, совпадающие с id данного поля
        switch(id)
        {
            // Проверка email
            case 'auth-email':
                var rv_email = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
                if(val != '' && rv_email.test(val))
                {
                    $(this).addClass('not-error-auth');
                    $('.error-block-auth').text("");
                }
                else
                {
                    if ($('.error-block-auth').html() === '') {
                        $(this).removeClass('not-error-auth').addClass('error-auth');
                        $(".error-block-auth").html('Введите корректный почтовый<br>адрес')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;

            // Проверка поля password
            case 'auth-password':
                if(val != '' && val.length <= 20 && val.length >= 6)
                {
                    $(this).addClass('not-error-auth');
                    $('.error-block-auth').text("");
                }
                else
                {
                    if ($('.error-block-auth').html() === '') {
                        $(this).removeClass('not-error-auth').addClass('error-auth');
                        $(".error-block-auth").html('Поле "Пароль" должно содержать<br>не менее 6 символов')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;

        } // end switch(...)

    }); // end blur()

    $('#submitAuthBtn').on('click', function () {
        if($('.not-error-auth').length == 2) {
            $.ajax({
                url: '/enter',
                type: 'post',
                data: $('form#auth-form').serialize(),
                async: false,
                beforeSend: function (xhr, textStatus) {
                    $('form#auth-form :input').attr('disabled', 'disabled');
                },
                success: function (response) {
                    $('form#auth-form :input').removeAttr('disabled');

                    if (response.toString() === 'submit') {
                        $('form#auth-form').submit();
                    } else if (response.toString() === 'no such user') {
                        $(".error-block-auth").html('Пользователя с таким адресом<br>не существует')
                            .css('color', 'red');
                    } else {
                        $(".error-block-auth").html('Пароль введен неверно')
                            .css('color', 'red');
                    }
                }
            })
        }
    });
}); // end script