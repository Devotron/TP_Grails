
function initMap() {
    //poiLat, poiLng
    //var APIKey = "AIzaSyC5g3lROuua5hCO4WwJSwDXEPqaogMawVU";
    //var latitude = document.getElementById('lat').value;
    //var longitude = document.getElementById('lon').value;
    //
    //var poi = {lat: poiLat, lng: poiLng};
    var c = {lat:43.616700, lng: 7.063751};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: c
    });

    /*var marker = new google.maps.Marker({
        map: map,
        label: 'POI',
        position: poi
    });*/
}

