const API_URL = 'http://localhost:8080/backend/api/v1/complains';

$(document).ready(() => {
    getAllComplains();

    $('#complianTableBody').on('click', '.delete-btn', function () {
        const row = $(this).closest('tr');
        const id = $(this).data('id');

        if (!confirm(`Are you sure you want to delete complaint ID ${id}?`)) return;

        $.ajax({
            url: API_URL,
            method: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify({ id }),
            success: () => {
                row.remove();
                console.log(`Complaint ID ${id} deleted`);
                getAllComplains();
            },
            error: (err) => {
                console.error(`Failed to delete complaint ID ${id}`, err);
            }
        });
    });
});

const getAllComplains = () => {
    $.ajax({
        url: API_URL,
        method: 'GET',
        success: (res) => {
            $('#complianTableBody').empty();
            res.forEach(complain => {
                $('#complianTableBody').append(`
                    <tr>
                         <td>${complain.id}</td>
                        <td>${complain.name}</td>
                        <td>${complain.message}</td>
                        <td>${complain.email}</td>
                        <td>
                            <button class="btn btn-danger delete-btn" data-id="${complain.id}">Delete</button>
                        </td>
                        <td>
                            <input type="checkbox" class="form-check-input">
                        </td>
                    </tr>
                `);
            });
        },
        error: (err) => {
            console.log(err);
        }
    });
};
