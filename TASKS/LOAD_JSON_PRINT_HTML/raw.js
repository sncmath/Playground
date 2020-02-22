    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var response = JSON.parse(xhttp.responseText);
        var data = response.data;

        var output = '';
        output += '<div class="row edit">';
        output += '<div class="id">' + 'id' + '</div>';
        output += '<div class="parent_id">' + 'parent_id' + '</div>';
        output += '<div class="project">' + 'project' + '</div>';
        output += '<div class="subject">' + 'subject' + '</div>';
        output += '<div class="type">' + 'type' + '</div>';
        output += '<div class="status">' + 'status' + '</div>';
        output += '<div class="priority">' + 'priority' + '</div>';
        output += '<div class="assignee">' + 'assignee' + '</div>';
        output += '<div class="category">' + 'category' + '</div>';
        output += '<div class="start_date">' + 'start_date' + '</div>';
        output += '<div class="finish_date">' + 'finish_date' + '</div>';
        output += '<div class="estimated">' + 'estimated' + '</div>';
        output += '<div class="spent_time">' + 'spent_time' + '</div>';
        output += '<div class="progress">' + 'progress' + '</div>';
        output += '<div class="description">' + 'description' + '</div>';
        output += '</div>';

        for (var i = 0; i < data.length; i++) {
          output += '<div class="row">';
          output += '<div class="id">' + data[i].id + '</div>';
          output += '<div class="parent_id">' + data[i].parent_id + '</div>';
          output += '<div class="project">' + data[i].project + '</div>';
          output += '<div class="subject">' + data[i].subject + '</div>';
          output += '<div class="type">' + data[i].type + '</div>';
          output += '<div class="status">' + data[i].status + '</div>';
          output += '<div class="priority">' + data[i].priority + '</div>';
          output += '<div class="assignee">' + data[i].assignee + '</div>';
          output += '<div class="category">' + data[i].category + '</div>';
          output += '<div class="start_date">' + data[i].start_date + '</div>';
          output += '<div class="finish_date">' + data[i].finish_date + '</div>';
          output += '<div class="estimated">' + data[i].estimated + '</div>';
          output += '<div class="spent_time">' + data[i].spent_time + '</div>';
          output += '<div class="progress">' + data[i].progress + '</div>';
          output += '<div class="description">' + data[i].description + '</div>';
          output += '</div>';
        }
        document.getElementById('disp').innerHTML = output;
      }
    };
    xhttp.open("GET", "csvjson.json", true);
    xhttp.send();