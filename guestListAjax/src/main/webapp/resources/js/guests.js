$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
    //var guestList = "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";
    //$("#guestList").html(data);
    console.log(data);
    let rawHtml = "";
    for(let row of data){
        rawHtml += `<li>${row.first} ${row.last}</li>`;
    }
    $("#guestList").html(rawHtml);
    
}