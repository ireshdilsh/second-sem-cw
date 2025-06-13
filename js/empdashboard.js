const API_URL = 'http://localhost:8080/backend/api/v1/employee';

$(document).ready(() => {
   
});

// const getAllComplains = () => {
//     $.ajax({
//         url: API_URL,
//         method: 'GET',
//         success: (res) => {
//             $('#complianTableBodyEmp').empty();
//             res.forEach(complain => {
//                 $('#complianTableBodyEmp').append(`
//                     <tr>
//                          <td>${complain.id}</td>
//                         <td>${complain.message}</td>
//                     </tr>
//                 `);
//             });
//         },
//         error: (err) => {
//             console.log(err);
//         }
//     });
// };
