$('#userRegisterBtn').on('click',()=>{

    const API_URL = ''

    const admin = {
        name : $('#name').val(),
        email : $('#email').val(),
        password : $('#password').val()
    }

   $.ajax({
    url : API_URL,
    method : 'POST',
    contentType : 'application/json',
    data : JSON.stringify(admin),
    success : (res)=>{
        console.log(res);
        window.location.href = '../pages/signin.html'
    },
    error : (err)=>{
        console.log(err);
    }
   })
})