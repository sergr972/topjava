const userAjaxUrl = "admin/users/";

// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: userAjaxUrl,
    updateTable: function () {
        $.get(userAjaxUrl, updateTableByData);
    }
}

function enable(chekbox, id) {
    var enabled = chekbox.is(":checked");
    $.ajax({
        url: "GET" /userAjaxUrl + id,
        // type: "GET"
        data: "enabled=" + enabled
    }).done(function () {
        chekbox.closest("tr").attr("user-enabled", enabled);
        successNoty(enabled ? "Enabled" : "Disabled");
    }).fail(function () {
        $(chekbox).prop("checked", !enabled);
    });
}

// $(document).ready(function () {
$(function () {
    makeEditable(
        $("#datatable").DataTable({
            "paging": false,
            "info": true,
            "columns": [
                {
                    "data": "name"
                },
                {
                    "data": "email"
                },
                {
                    "data": "roles"
                },
                {
                    "data": "enabled"
                },
                {
                    "data": "registered"
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false
                }
            ],
            "order": [
                [
                    0,
                    "asc"
                ]
            ]
        })
    );
});