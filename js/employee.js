$('#empRegisterBtn').on('click', () => {

    const API_URL = 'http://localhost:8080/backend/api/v1/employee'

    const employee = {
        id: $('#id').val(),
        name: $('#name').val(),
        email: $('#email').val(),
        contact: $('#contact').val()
    }

    $.ajax({
        url: API_URL,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: (res) => {
            console.log(res);
            Swal.fire({
                title: "Good job!",
                text: "Employee Saved !",
                icon: "success"
            });
            clearFields()
            window.location.href = '../pages/employeeDashboard.html'
        },
        error: (err) => {
            console.log(err);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Something went wrong!"
            });
        }
    })
})

const clearFields = () => {
    $('#id').val('')
    $('#name').val('')
    $('#email').val('')
    $('#contact').val('')
}