$('#loginBtn').on('click', () => {

    const API_URL = 'http://localhost:8080/backend/api/v1/admin/signin'
    const loginData = {
        email: $('#email').val(),
        password: $('#password').val()
    }

    $.ajax({
        url: API_URL,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: (res) => {
            console.log(res);
            clearFields()
            window.location.href = '../pages/dashboard.html'

            $('#admin-section').css('display', 'block')
            $('#employee-section').css('display', 'none')
        },
        error: (err) => {
            alert('Something Wrong')
            console.log(err);
        }
    })
})

const clearFields = () => {
    $('#email').val('')
    $('#password').val('')
}