$(document).ready(function() {
    var first = document.getElementsByClassName("first")[0];
    first.getElementsByClassName("page-link")[0].innerHTML = "«";

    var prev = document.getElementsByClassName("prev")[0];
    prev.getElementsByClassName("page-link")[0].innerHTML = "‹";

    var next = document.getElementsByClassName("next")[0];
    next.getElementsByClassName("page-link")[0].innerHTML = "›";

    var last = document.getElementsByClassName("last")[0];
    last.getElementsByClassName("page-link")[0].innerHTML = "»";
});