$('#empRegisterBtn').on('click', () => {

    const API_URL = 'http://localhost:8080/backend/api/v1/employee'

    const employee = {
        id: $('#id').val(),
        name: $('#name').val(),
        email: $('#email').val(),
        password: $('#contact').val()
    }

    $.ajax({
        url: API_URL,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: (res) => {
            console.log(res);
            alert("save success")
            clearFields()
        },
        error: (err) => {
            console.log(err);
            alert(err.responseJSON.message)
        }
    })
})

const clearFields = () => {
    $('#id').val('')
    $('#name').val('')
    $('#email').val('')
    $('#contact').val('')
}