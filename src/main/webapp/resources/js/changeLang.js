$(document).ready(function () {
    $('#englishRef').on('click', function () {
        if ($('#englishRef').attr('href').indexOf('lang=') >= 0) {
            $('#englishRef').attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "en" + '$2'));
        } else {
            $('#englishRef').attr('href', $(location).attr('href') + '?lang=en');
        }
        //var newText = text.replace(/(src=).*?(&)/,'$1' + newSrc + '$2');
    });
    $('#russianRef').on('click', function () {
        if ($('#russianRef').attr('href').indexOf('lang=') >= 0) {
            $('#russianRef').attr('href', $(location).attr('href').replace(/(lang=).*?(&)/, '$1' + "ru" + '$2'));
        } else {
            $('#russianRef').attr('href', $(location).attr('href') + '?lang=ru');
        }
    });
});