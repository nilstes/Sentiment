$(document).ready(function() {
    // Log in
    $("#analyzeForm").submit(function(event) {
        event.preventDefault();
        $.ajax({
            url: 'webresources/sentiment?api-key=Happy!!!',
            type: 'POST',
            data: JSON.stringify({sentence: $("#inputText").val()}),
            contentType: 'application/json',
            dataType: 'json',
            complete: function(xhr) {
                switch (xhr.status) {
                    case 200:
                        $("#emoticon").attr("src", "images/sentiment" + xhr.responseJSON.value + ".png");
                        $("#emoticon").removeClass("hide");
                        break;
                    default:
                        $("#emoticon").addClass("hide");
                        $("#errorAlert").removeClass("hide");
                        break;
                }
            }
        });
    });
});