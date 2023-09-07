let intervalList = [];
let deleteList = [];
let qcImg;
function showVillaList(){
    let data = "";
    for (let i = 0; i < dataVilla.length; i++){
        let villa = dataVilla[i];
        data +=
            `<div class="villa boxshadow-outset" onmouseover="hoverVilla(${i})" onmouseleave="stopHover(${i})">
                <div class="villa-picture" id="villa-${i}" style="background-image: url('${villa.getImg()[0]}')"></div>
                <button onclick="openEditBoard(${i})" class="edit backgroundcolor-2 hover">Sửa</button>
                <button onclick="deleteVilla(${villa.getId()})" class="delete backgroundcolor-2 hover">Xóa</button>
            </div>`
    }
    data += `<div class="villa boxshadow-outset" id="addVilla" onclick="addVilla()"></div>`
    document.getElementById("villa-list").innerHTML = data;
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
function openEditBoard(index){
    deleteList = [];
    let villaDetail = dataVilla[index];
    let board = document.getElementById("edit-board");
    board.style.display = "grid";

    qcImg = villaDetail.getImg().length;

    document.getElementById("input-area").value = villaDetail.area;
    document.getElementById("input-width").value = villaDetail.width;
    document.getElementById("input-deep").value = villaDetail.deep;
    document.getElementById("input-price").value = villaDetail.price;
    document.getElementById("input-level").value = villaDetail.level;
    document.getElementById("input-garage").value = villaDetail.garage;
    document.getElementById("input-gym").value = villaDetail.gym;
    document.getElementById("input-relax").value = villaDetail.relax;
    document.getElementById("input-toilet").value = villaDetail.toilet;
    document.getElementById("input-living").value = villaDetail.living;
    document.getElementById("input-kitchen").value = villaDetail.kitchen;
    document.getElementById("input-bedroom").value = villaDetail.bedroom;
    document.getElementById("input-capacity").value = villaDetail.capacity;
    document.getElementById("villaId").value = villaDetail.getId();

    let arrayPicture = `<img id="add-detail-picture" onclick="addDetailPicture(${villaDetail.getId()})" class="array-detail-picture boxshadow-outset hover-in">`;
    for (let i = 0; i < villaDetail.getImg().length; i++){
        arrayPicture += `<img id="array-picture-${villaDetail.getImgId()[i]}" onclick="tickPicture(${villaDetail.getImgId()[i]})" src="${villaDetail.getImg()[i]}" 
                            class="hover-in array-detail-picture boxshadow-outset">`
    }
    document.getElementById("picture").innerHTML = arrayPicture;

    document.getElementById("map-detail-picture").style.backgroundImage = `url("${villaDetail.getMap()}")`;
}
function closeEditBoard(){
    let board = document.getElementById("edit-board");
    board.style.display = "none";
}
function addVilla(){}
function addDetailPicture(villaId){}
function deleteVilla(villaId){
    let villaDelete = document.getElementById("delete-board");
    villaDelete.style.display = "grid";
    document.getElementById("villa-delete-id").innerHTML = villaId
    document.getElementById("villa-delete").value = "Villa " + villaId;
}

function closeDeleteBoard(){
    let villaDelete = document.getElementById("delete-board");
    villaDelete.style.display = "none";
}
function backToMainPage(){
    window.location.href = "/main-page-controller?action=backToMain";
}
let countdownInterval;
function logout(){
    document.getElementById("count-down").innerHTML = "10";
    let logoutBoard = document.getElementById("logout-board");
    logoutBoard.style.display = "grid";

    let buttonElement = document.getElementById("logout-now");
    let countdown = 10;

    countdownInterval = setInterval(function() {
        countdown--;
        document.getElementById("count-down").innerHTML = countdown;

        if (countdown === 0) {
            clearInterval(countdownInterval);
            buttonElement.removeAttribute('disabled');
            buttonElement.click();
        }
    }, 1000);
}
function logoutNow(){
    window.location.href = "/main-page-controller?action=logout";
}
function cancelLogout(){
    clearInterval(countdownInterval);
    let logoutBoard = document.getElementById("logout-board");
    logoutBoard.style.display = "none";
}
function tickPicture(index){
    let stringIndex = index + "";
    let style = "3px solid red"
    let picture = document.getElementById("array-picture-" + index);
    if (picture.style.border + "" == style){
        picture.style.border = "none";
        deleteList = deleteList.filter(item => item !== stringIndex);
    } else {
        if (qcImg - 1 == deleteList.length){
            alertChooseAllPicture();
        } else {
            picture.style.border = style;
            deleteList.push(stringIndex);
        }
    }
    document.getElementById("deleteimg").value = deleteList;
}
function alertChooseAllPicture(){
    let alertWarning = document.getElementById("alert-choose-picture");
    alertWarning.style.display = "flex";
}
function closeAlertChooseAllPicture(){
    let alertWarning = document.getElementById("alert-choose-picture");
    alertWarning.style.display = "none";
}
