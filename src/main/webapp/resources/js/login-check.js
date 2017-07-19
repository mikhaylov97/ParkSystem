$(document).ready(function(){

    // Устанавливаем обработчик потери фокуса для всех полей ввода текста
    $('input#email, input#name, input#surname, input#password').unbind().blur( function(){

        // Для удобства записываем обращения к атрибуту и значению каждого поля в переменные
        var id = $(this).attr('id');
        var val = $(this).val();
        var formHasErrors = false;

        // После того, как поле потеряло фокус, перебираем значения id, совпадающие с id данного поля
        switch(id)
        {
            // Проверка email
            case 'email':
                var rv_email = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
                if(val != '' && rv_email.test(val))
                {
                    $(this).addClass('not_error');
                    $('.error-block').text("");
                }
                else
                {
                    if ($('.error-block').html() === '') {
                        $(this).removeClass('not_error').addClass('error');
                        $(".error-block").html('Введите корректный почтовый<br>адрес')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;

            case 'name':
                var rv_name = /^[a-zA-Zа-яА-Я]+$/; // используем регулярное выражение

                // Eсли длина имени больше 2 символов, оно не пустое и удовлетворяет рег. выражению,
                // то добавляем этому полю класс .not_error,
                // и ниже в контейнер для ошибок выводим слово " Принято", т.е. валидация для этого поля пройдена успешно

                if(val.length > 2 && val != '' && rv_name.test(val))
                {
                    $(this).addClass('not_error');
                    $('.error-block').text("");
                }
                // Иначе, мы удаляем класс not-error и заменяем его на класс error, говоря о том что поле содержит ошибку валидации,
                // и ниже в наш контейнер выводим сообщение об ошибке и параметры для верной валидации
                else
                {
                    if ($('.error-block').html() === '') {
                        $(this).removeClass('not_error').addClass('error');
                        $(".error-block").html('Поле "Имя" должно содержать<br>не менее 2 символов')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;
            // Проверка поля "Имя"
            case 'surname':
                var rv_name = /^[a-zA-Zа-яА-Я]+$/; // используем регулярное выражение

                // Eсли длина имени больше 2 символов, оно не пустое и удовлетворяет рег. выражению,
                // то добавляем этому полю класс .not_error,
                // и ниже в контейнер для ошибок выводим слово " Принято", т.е. валидация для этого поля пройдена успешно

                if(val.length > 2 && val != '' && rv_name.test(val))
                {
                    $(this).addClass('not_error');
                    $('.error-block').text("");
                }
                // Иначе, мы удаляем класс not-error и заменяем его на класс error, говоря о том что поле содержит ошибку валидации,
                // и ниже в наш контейнер выводим сообщение об ошибке и параметры для верной валидации
                else
                {
                    if ($('.error-block').html() === '') {
                        formHasErrors = true;
                        $(this).removeClass('not_error').addClass('error');
                        $(".error-block").html('Поле "Фамилия" должно содержать<br>не менее 2 символов')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;

            // Проверка поля password
            case 'password':
                if(val != '' && val.length <= 20 && val.length >= 6)
                {
                    $(this).addClass('not_error');
                    $('.error-block').text("");
                }
                else
                {
                    if ($('.error-block').html() === '') {
                        $(this).removeClass('not_error').addClass('error');
                        $(".error-block").html('Поле "Пароль" должно содержать<br>не менее 6 символов')
                            .css('color', 'red');
                        // .animate({'paddingLeft':'10px'},400)
                        // .animate({'paddingLeft':'5px'},400);
                    }
                }
                break;

        } // end switch(...)

    }); // end blur()

    $('#submitBtn').on('click', function () {
        if($('.not_error').length == 4) {
            $.ajax({
                url: '/checkEmail',
                type: 'post',
                data: $('form#login-form').serialize(),
                async: false,
                beforeSend: function (xhr, textStatus) {
                    $('form#login-form :input').attr('disabled', 'disabled');
                },
                success: function (response) {
                    $('form#login-form :input').removeAttr('disabled');

                    if (response.toString() === 'true') {
                        $('form#login-form').submit();
                    } else {
                        $(".error-block").html('Данный email уже<br>занят')
                            .css('color', 'red');
                    }
                }
            })
        }
    });
}); // end script