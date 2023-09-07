function updateCalendar(){
    const currentDate = new Date();
    const day = currentDate.getDate();
    const month = currentDate.getMonth() + 1;
    const year = currentDate.getFullYear();

    const daysInMonth = new Date(year, month,0).getDate();
    let firstDayOfWeek = new Date(year, month - 1,1).getDay();

    document.getElementById("month-detail").innerHTML = month;
    document.getElementById("year-detail").innerHTML = year;

    let data =
        `<tr>
            <td>CN</td>
            <td>T2</td>
            <td>T3</td>
            <td>T4</td>
            <td>T5</td>
            <td>T6</td>
            <td>T7</td>
        </tr><tr>`;
    for (let i = 0; i < firstDayOfWeek; i++){
        data += `<td></td>`;
    }
    for (let i = 1; i <= daysInMonth; i++){
        firstDayOfWeek++;
        if (firstDayOfWeek % 7 == 1){
            data += `<tr>`;
        }
        if (i == day){
            data +=`<td id="today">${i}</td>`
        }else {
            data +=`<td>${i}</td>`
        }
        if (firstDayOfWeek % 7 == 0 || i == daysInMonth){
            data += `</tr>`
        }
    }
    document.getElementById("calendar-table").innerHTML = data;
}
updateCalendar();