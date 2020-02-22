var xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function() {
  var darkcolor = "#B35900";
  var lightcolor = "#E67300";
  var fontcolor = "#FFFFFF";
  var moreBtnBackcolor = "#FFFFFF";

  if (this.readyState == 4 && this.status == 200) {
    var response = JSON.parse(xhttp.responseText);
    var data = response.results;

    var parent = document.getElementById("parent");
    var container = document.createElement("div");
    parent.appendChild(container);

    var genreBox = document.createElement("div");
    container.appendChild(genreBox);
    genreBox.style = "border-bottom:0.25vw solid #ffffff;padding: 2% 1%;";
    genreBox.style.backgroundColor = lightcolor;

    var genre = document.createElement("span");
    genreBox.appendChild(genre);
    genre.innerHTML = "MOVIES NOW PLAYING";
    genre.style = "font: small-caps 700 2.44vw cursive;";
    genre.style.color = fontcolor;

    for (var i = 0; i < data.length; i++) {
      var picpath =
        "https://image.tmdb.org/t/p/w200" +
        data[i].poster_path +
        "?api_key=e71a5346f06f5cfba7b4514c607ce80e&region=US";

      var card = document.createElement("div");
      container.appendChild(card);
      card.style = "border-bottom:0.25vw solid #ffffff";
      card.style.backgroundColor = lightcolor;

      var imageBox = document.createElement("div");
      card.appendChild(imageBox);
      imageBox.style = "float:left;width:15%;padding:1%";
      imageBox.style.backgroundColor = darkcolor;

      var textBox = document.createElement("div");
      card.appendChild(textBox);
      textBox.style = "float:left;width:65%;padding:1%";

      var detailsBox = document.createElement("div");
      card.appendChild(detailsBox);
      detailsBox.style = "float:left;width:20%;padding:1%";

      var btnBox = document.createElement("div");
      detailsBox.appendChild(btnBox);
      btnBox.style = "text-align:center;";

      var moreBtn = document.createElement("button");
      btnBox.appendChild(moreBtn);
      moreBtn.innerHTML = "MORE";
      moreBtn.style =
        "border:0;border-radius:1.95vw;background-color:#FFFFFF;padding:10px 20px;box-shadow: 1px 1px 5px #00000040;font:italic small-caps 700 1.17vw cursive";
      moreBtn.style.color = darkcolor;
      moreBtn.style.backgroundColor = moreBtnBackcolor;
      moreBtn.id = "btn" + i;
      moreBtn.onclick = function myFunction() {
        if (moreBtn.innerHTML == "MORE") {
          detailslist.style.visibility = "visible";
          moreBtn.innerHTML = "LESS";
        } else {
          detailslist.style.visibility = "hidden";
          moreBtn.innerHTML = "MORE";
        }
      };

      var detailslist = document.createElement("div");
      detailsBox.appendChild(detailslist);
      detailslist.id = "list" + i;
      detailslist.style =
        "padding: 18% 0;box-shadow: 1px 1px 5px #00000040;text-align:center;border-radius: 1.56vw";
      detailslist.style.backgroundColor = darkcolor;
      detailslist.style.visibility = "hidden";

      var release = document.createElement("p");
      detailslist.appendChild(release);
      release.innerHTML = "Release: " + data[i].release_date;
      release.style = "font:italic small-caps 700 1.17vw cursive;margin:2% 0;";
      release.style.color = fontcolor;

      var rating = document.createElement("p");
      detailslist.appendChild(rating);
      rating.innerHTML = "Rating: " + data[i].vote_average;
      rating.style = "font:italic small-caps 700 1.17vw cursive;margin:2% 0;";
      rating.style.color = fontcolor;

      var adult = document.createElement("p");
      detailslist.appendChild(adult);
      adult.innerHTML = "Adult Rated: " + data[i].adult;
      adult.style = "font:italic small-caps 700 1.17vw cursive;margin:2% 0;";
      adult.style.color = fontcolor;

      var clear = document.createElement("div");
      card.appendChild(clear);
      clear.style = "clear:both";

      var image = document.createElement("img");
      imageBox.appendChild(image);
      image.src = picpath;
      image.style = "width:100%;border-radius: 1.56vw";

      var title = document.createElement("span");
      textBox.appendChild(title);
      title.innerHTML = data[i].original_title;
      title.style = "font:italic small-caps 700 2.44vw cursive;";
      title.style.color = fontcolor;

      var overview = document.createElement("p");
      textBox.appendChild(overview);
      overview.innerHTML = "<u>OVERVIEW</u>:</br> " + data[i].overview;
      overview.style =
        "font:italic small-caps 700 0.97vw cursive;color:#000000;margin-top:3%;";
      overview.style.color = fontcolor;
    }
    var nextrow = document.createElement("div");
    container.appendChild(nextrow);
    nextrow.style = "padding:2%; text-align:center";
    nextrow.style.backgroundColor = lightcolor;

    var button = document.createElement("button");
    nextrow.appendChild(button);
    button.innerHTML = "UPCOMING MOVIES";
    button.style =
      "border:0;border-radius:1.95vw;padding:1% 2%;color:#FFFFFF;box-shadow: 1px 1px 5px #00000040;font:italic small-caps 600 1.17vw cursive";
    button.style.backgroundColor = darkcolor;
    button.onclick = function() {
      window.open("movie2.html", "_self", false);
    };
  }
};
xhttp.open(
  "GET",
  "https://api.themoviedb.org/3/movie/now_playing?api_key=e71a5346f06f5cfba7b4514c607ce80e&region=US",
  true
);
xhttp.send();
