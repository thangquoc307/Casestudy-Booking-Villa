class villa {
    constructor(img, price, level, area, width, deep, map, bedroom,
                kitchen, living, toilet, relax, gym, garage, id ,
                capacity, imgId) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.level = level;
        this.area = area;
        this.width = width;
        this.deep = deep;
        this.map = map;
        this.bedroom = bedroom;
        this.kitchen = kitchen;
        this.living = living;
        this.toilet = toilet;
        this.relax = relax;
        this.gym = gym;
        this.garage = garage;
        this.imgId = imgId;
        this.capacity = capacity;
    }
    getImgId(){
        return this.imgId;
    }
    getCapacity(){
        return "Sức chứa : " + this.capacity
    }
    getId(){
        return this.id;
    }
    getImg(){
        return this.img;
    }
    getPrice(){
        return this.price;
    }
    getLevel(){
        return this.level;
    }
    getArea(){
        return this.area;
    }
    getWidth(){
        return this.width;
    }
    getDeep(){
        return this.deep;
    }
    getMap(){
        return this.map;
    }
    getBedroom(){
        if(this.bedroom == 0){
            return 0;
        } else {
            return "Phòng ngủ : " + this.bedroom;
        }
    }
    getKitchen(){
        if(this.kitchen == 0){
            return 0;
        } else {
            return "Phòng bếp : " + this.kitchen;
        }
    }
    getLiving(){
        if(this.living == 0){
            return 0;
        } else {
            return "Phòng khách : " + this.living;
        }
    }
    getToilet(){
        if(this.toilet == 0){
            return 0;
        } else {
            return "Phòng vệ sinh : " + this.toilet;
        }
    }
    getRelax(){
        if(this.relax == 0){
            return 0;
        } else {
            return "Phòng giải trí : " + this.relax;
        }
    }
    getGym(){
        if(this.gym == 0){
            return 0;
        } else {
            return "Phòng gym : " + this.gym;
        }
    }
    getGarage(){
        if(this.garage == 0){
            return 0;
        } else {
            return "Nhà để xe : " + this.garage;
        }
    }
    setId(id){
        this.id = id;
    }
    setImg(img){
        this.img = img;
    }
    setPrice(price){
        this.price = price;
    }
    setLevel(level){
        this.level = level;
    }
    setArea(area){
        this.area = area;
    }
    setWidth(width){
        this.width = width;
    }
    setDeep(deep){
        this.deep = deep;
    }
    setMap(map){
        this.map = map;
    }
    setBedroom(bedroom){
        this.bedroom = bedroom;
    }
    setKitchen(kitchen){
        this.kitchen = kitchen;
    }
    setLiving(living){
        this.living = living;
    }
    setToilet(toilet){
        this.toilet = toilet;
    }
    setRelax(relax){
        this.relax = relax;
    }
    setGym(gym){
        this.gym = gym;
    }
    setGarage(garage){
        this.garage = garage;
    }
    setImgId(imgId){
        this.imgId = imgId;
    }
    setCapacity(capacity){
        this.capacity = capacity;
    }
}