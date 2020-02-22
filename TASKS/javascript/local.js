var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
  if (this.readyState == 4 && this.status == 200) {
    var response = JSON.parse(xhttp.responseText);
    var data = response.results;
    console.log(data);

    var parent = document.getElementById("parent");
    var container = document.createElement("div");
    parent.appendChild(container);

    var parent = document.getElementById("parent");
    var container = document.createElement("div");
    parent.appendChild(container);

    for (let i = 0; i < data.length; i++) {
      var picpath =
        "https://image.tmdb.org/t/p/w200" +
        response.results[i].poster_path +
        "?api_key=e71a5346f06f5cfba7b4514c607ce80e&region=US";
      console.log(picpath);

      var card = document.createElement("div");
      container.appendChild(card);
      card.style = "background-color:#0099ff;border-bottom:0.25vw solid #ffffff";

      var imageBox = document.createElement("div");
      card.appendChild(imageBox);
      imageBox.style = "float:left;width:15%;background-color:#0066ff;padding:1%";

      var textBox = document.createElement("div");
      card.appendChild(textBox);
      textBox.style = "float:right;width:85%;padding:1%";

      var clear = document.createElement("div");
      card.appendChild(clear);
      clear.style = "clear:both";

      var image = document.createElement("img");
      imageBox.appendChild(image);
      image.src = picpath;
      image.style = "width:100%;border-radius: 1.56vw"

      var title = document.createElement("span");
      textBox.appendChild(title);
      title.innerHTML = data[i].original_title;
      title.style = "font:italic small-caps 700 32px cursive;color:#000000;text-shadow: 2px 2px #0066ff;"

      var overview = document.createElement("p");
      textBox.appendChild(overview);
      overview.innerHTML = "<u>OVERVIEW</u>:</br> " + data[i].overview;
      overview.style = "font:italic small-caps 700 16px cursive;color:#000000;margin-top:3%;width:70%"

    }

  }
};
xhttp.open(
  "GET",
  "movie.json",
  true
);
xhttp.send();