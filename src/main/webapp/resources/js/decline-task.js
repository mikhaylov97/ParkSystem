$(document.ready(function() {

    $('#declineBtn').on('click', function () {
            $.ajax({
                url: '/admin/accepting/decline/'+$('#declineBtn').val(),
                type: 'post',
                data: $('form#acceptingForm').serialize(),
                async: false
            })
    });
}));
