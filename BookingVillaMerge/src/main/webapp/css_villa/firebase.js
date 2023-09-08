import { initializeApp }
    from "https://www.gstatic.com/firebasejs/10.3.1/firebase-app.js";
import { getStorage, ref, uploadBytes, getDownloadURL  }
    from "https://www.gstatic.com/firebasejs/10.3.1/firebase-storage.js";

const firebaseConfig = {
    apiKey: "AIzaSyCdVT5o76hLZM1RkcEtDeJEfCuYlDK-nEg",
    authDomain: "thangquocproject.firebaseapp.com",
    projectId: "thangquocproject",
    storageBucket: "thangquocproject.appspot.com",
    messagingSenderId: "1056348119656",
    appId: "1:1056348119656:web:19639bc4aa441af953d1dd"
};
const app = initializeApp(firebaseConfig);
const storage = getStorage(app);

const inp = document.querySelector(".inp");
const inps = document.querySelector(".inps");


async function handleUpload(index) {
    if (index == 1) {
        const file = inp.files[0];
        if (file) {
            const snapshot = await uploadImage(file);
            const downloadURL = await getDownloadURL(snapshot.ref);
            displayDownloadLink(downloadURL);
        } else {
            console.error("No file selected.");
        }
    } else {
        let links = "";
        for (let i = 0; i < inps.files.length; i++) {
            let file = inps.files[i];
            if (file) {
                const snapshot = await uploadImage(file);
                const downloadURL = await getDownloadURL(snapshot.ref);
                links += (downloadURL + " ");
                insertPicture(downloadURL);
            } else {
                console.error("No file selected.");
            }
        }
        displayDownloadDetailLink(links.trim());
    }
}

async function uploadImage(file) {
    const storageRef = ref(storage, 'images/' + file.name);
    const snapshot = await uploadBytes(storageRef, file);
    return snapshot;
}
function displayDownloadLink(url) {
    document.getElementById("map-detail-picture").style.backgroundImage = `url("${url}")`;
    document.getElementById("inputMap").value = url;
}
function displayDownloadDetailLink(url){
    document.getElementById("inputDetailPic").value = url;
}
function insertPicture(url){
    let data =  `<img src="${url}" class="newpicture array-detail-picture boxshadow-outset">`
    document.getElementById("picture").innerHTML += data;
}
window.handleUpload = handleUpload;