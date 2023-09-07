let intervalList = [];
function updateVillaList(){
    let data = "";
    for (let i = 0; i < dataVilla.length; i++){
        let villa = dataVilla[i];
        data +=
            `<div class="villa boxshadow-outset" onmouseover="hoverVilla(${i})" onmouseleave="stopHover(${i})">
                <div class="villa-description">
                    <p>Diện tích : <span class="villa-description-text">${villa.getArea()}</span> m<sup>2</sup></p>
                    <p>Số tầng : <span class="villa-description-text">${villa.getLevel()}</span> tầng</p>
                    <p>Chiều ngang : <span class="villa-description-text">${villa.getWidth()}</span> m</p>
                    <p>Chiều sâu : <span class="villa-description-text">${villa.getDeep()}</span> m</p>
                    <br>
                    <p class="backgroundcolor-2 price-overview">${toPriceString(villa.getPrice())}</p>
                </div>
                <div class="villa-picture" id="villa-${i}" style="background-image: url('${villa.getImg()[0]}')"></div>
                <div class="villa-map"></div>
                <div class="villa-price">
                    <p onclick="detailVilla(${i})" class="backgroundcolor-4 hover">Chi tiết</p>
                </div>
            </div>`
    }
    document.getElementById("villa-list").innerHTML = data;
}
function toPriceString(str){
    str += "";
    let result = "";
    for (let i = 0; i < str.length; i++){
        result = str[str.length - 1 - i] + result;
        if (i % 3 == 2 && i + 1 != str.length){
            result = "," + result;
        }
    }
    return result + " / ngày";
}
function hoverVilla(index){
    let item = document.getElementById("villa-" + index);
    let count = 0;
    let image = dataVilla[index].getImg();
    let interval = setInterval(function () {
        count = (count + 1) % image.length;
        item.style.backgroundImage = `url('${image[count]}')`;
    },1300);
    intervalList.push(interval);
}
function stopHover(index){
    let item = document.getElementById("villa-" + index);
    let image = dataVilla[index].getImg();
        item.style.backgroundImage = `url('${image[0]}')`;
        for (let i = 0; i < intervalList.length;i++){
            clearInterval(intervalList[i]);
        }
        intervalList = [];
}
function detailVilla(index){
    let villa = dataVilla[index];
    let board = document.getElementById("detail-board");
    let close = document.getElementById("close-detail-board");
    let map = document.getElementById("map");

    let price = `<p class="backgroundcolor-3 hover boxshadow-outset" id="detail-board-booking-price"`;
    if (checkRole){
        price += ` onclick="booking(${villa.getId()})">Booking : ${toPriceString(villa.getPrice())}`;
    } else {
        price += ` onclick="signup()">Đăng nhập để sử dụng`;
    }
    price += `</p>`;

    board.style.display = "grid";
    close.style.display = "block";
    map.style.backgroundImage = `url(${villa.getMap()})`;
    let dataArray = "";
    for (let i = 0; i < villa.getImg().length; i++){
        dataArray += `<img onclick="change_main_img('${villa.getImg()[i]}')" class="image-array boxshadow-outset hover-in" src="${villa.getImg()[i]}">`
    }
    document.getElementById("detail-board-picture-array-branch").innerHTML = dataArray;
    document.getElementById("detail-board-booking").innerHTML = price;
    let dataMainPicture = villa.getImg()[0];
    document.getElementById("detail-board-picture-array-main").style.backgroundImage = `url("${dataMainPicture}")`;
    let description = [];
    let dataFull = ["Diện tích : " + villa.getArea() + " m<sup>2</sup>",
        "Chiều dài : " + villa.getWidth() + " m", "Chiều sâu : " + villa.getDeep() + " m", villa.getCapacity(), villa.getKitchen(),
        villa.getBedroom(),villa.getLiving(),villa.getToilet(),villa.getRelax(),villa.getGym(),"Số tầng : " + villa.getLevel(),
        villa.getGarage()];
    for (let i = 0; i < dataFull.length; i++){
        if (dataFull[i] != 0){
            description.push(dataFull[i]);
        }
    }
    let dataDescription = "";
    let numberItem = Math.ceil(description.length / 2);
    for (let i = 0; i < description.length; i++){
        if (i % numberItem == 0){
            dataDescription += `<tr>`;
        }
        dataDescription += `<td style="width: ${100 / numberItem}%"><p class="backgroundcolor-2">${description[i]}</p></td>`;
        if (i == description.length - 1 || i % numberItem == numberItem - 1){
            dataDescription += `</tr>`;
        }
    }
    document.getElementById("table-description").innerHTML = dataDescription;
}
function close_detail_board(){
    let board = document.getElementById("detail-board");
    board.style.display = "none";
}
function change_main_img(link){
    document.getElementById("detail-board-picture-array-main").style.backgroundImage = `url("${link}")`;
}
function quickLogin(){
    let loginTable = document.getElementById("login");
    let loginButton = document.getElementById("buttonLogin");
    let signUpButton = document.getElementById("buttonSignUp");


    loginTable.style.display = "block";
    loginButton.style.display = "none";
    signUpButton.style.display = "none";
}
function closeLogin(){
    let loginTable = document.getElementById("login");
    let loginButton = document.getElementById("buttonLogin");
    let signUpButton = document.getElementById("buttonSignUp");

    loginTable.style.display = "none";
    loginButton.style.display = "block";
    signUpButton.style.display = "block";
}
function booking(index){
    window.location.href = "/booking?action=showFormCreateBooking&index=" + index;
}
function signup(){
    window.location.href = "login.jsp"
}
function regist(){
    window.location.href = "signup-user.jsp";
}
