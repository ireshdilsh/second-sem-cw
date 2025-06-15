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
        },
        error: (err) => {
           Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Something went wrong!"
            });
            console.log(err);
        }
    })
})

const clearFields = () => {
    $('#email').val('')
    $('#password').val('')
}