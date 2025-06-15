<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Boostrap CSS File -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>

<body>

    <div class="form">
        <h1>Create Account</h1>
        <div class="mb-3">
            <label for="" class="form-label">Enter Full Name</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="" class="form-label">Create Password</label>
            <input type="password" class="form-control" id="password" aria-describedby="emailHelp">
        </div>
        <button class="btn btn-primary" id="userRegisterBtn">Create Account</button>
        <div class="lst">
            <label for="">if you already have an account ?</label>
            <a href="./index.jsp">sign in here</a>
        </div>
    </div>

    <!-- JQuerry.js File -->
    <script src="./jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- <script type="module" src="./js/signup.js"></script> -->
    <!-- Boostrap JS File -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>

    <script>
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
                    window.location.href = './index.jsp'
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
    </script>
</body>

</html>

<!-- pem madirawe jeewithe , mahamaya,senehasa pawa-->