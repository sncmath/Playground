function openNav() {
    document.getElementById("myNav").style.width = "100%";
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
}

function read( i, j) {
    var text = document.getElementById(i);
    var toggle = document.getElementById(j);
    if (toggle.innerHTML === "READ MORE") {
        text.style.height = "auto";
        toggle.innerHTML = "SHOW LESS";
    }
    else{
        text.style.height = "5.9vh";
        toggle.innerHTML = "READ MORE";
    }
}

function pop (k,l){
    var popup = document.getElementById(l);
    var anchor = document.getElementById(k);
    if(popup.style.display === "none"){
        anchor.style.position = "relative";
        popup.style.position = "absolute";
        popup.style.top = "100%";
        popup.style.right = "0";
        popup.style.display = "block";
        popup.style.zIndex = "1";
    }
    else{
        anchor.style.position = "initial";
        popup.style.position = "initial";
        popup.style.top = "initial";
        popup.style.right = "initial";
        popup.style.display = "none";
        popup.style.zIndex = "initial";
    }
}