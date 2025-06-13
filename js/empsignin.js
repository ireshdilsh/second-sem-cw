$('#empsigninBtn').on('click', () => {
    const url = 'http://localhost:8080/backend/api/v1/emp/signin'
    const loginsEmp = {
        email: $('#email').val(),
    }

    $.ajax({
        url: url,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(loginsEmp),
        success: (res) => {
            console.log(res);
            window.location.href = '../pages/empdash.html'
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