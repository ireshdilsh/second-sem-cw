$('#userRegisterBtn').on('click', () => {

    const API_URL = 'http://localhost:8080/backend/api/v1/admin'

    const admin = {
        name: $('#name').val(),
        email: $('#email').val(),
        password: $('#password').val()
    }

    $.ajax({
        url: API_URL,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(admin),
        success: (res) => {
            console.log(res);
            fieldsCler()
            Swal.fire({
                title: "Good job!",
                text: "Account Created !",
                icon: "success"
            });
            window.location.href = '../pages/signin.html'
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

const fieldsCler = () => {
    $('#name').val('')
    $('#email').val('')
    $('#password').val('')
}