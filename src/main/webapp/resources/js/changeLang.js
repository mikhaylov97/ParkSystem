$(document).ready(function () {
    $('#englishRef').on('click', function () {
        if ($(location).attr('href').indexOf('lang=') >= 0) {
            if ($(location).attr('href').indexOf('&', $(location).attr('href').indexOf('lang=')) >= 0) {
                $('#englishRef').attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "en" + '$2'));
            } else {
                $('#englishRef').attr('href', $(location).attr('href').replace(/lang=ru|lang=en/g, 'lang=en'));
            }
            //$(location).attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "en" + '$2'));
            //location.reload();
        } else {
            $('#englishRef').attr('href', $(location).attr('href') + '?lang=en');
            //$(location).attr('href', $(location).attr('href') + '?lang=en');
            //location.reload();
        }
        //var newText = text.replace(/(src=).*?(&)/,'$1' + newSrc + '$2');
    });
    $('#russianRef').on('click', function () {
        if ($(location).attr('href').indexOf('lang=') >= 0) {
            if ($(location).attr('href').indexOf('&', $(location).attr('href').indexOf('lang=')) >= 0) {
                $('#russianRef').attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "ru" + '$2'));
            } else {
                $('#russianRef').attr('href', $(location).attr('href').replace(/lang=ru|lang=en/g, "lang=ru"));
            }
           // $(location).attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "ru" + '$2'));
            //location.reload();
        } else {
            $('#russianRef').attr('href', $(location).attr('href') + '?lang=ru');
            //$(location).attr('href', $(location).attr('href') + '?lang=ru');
            //location.reload();
        }
    });
});