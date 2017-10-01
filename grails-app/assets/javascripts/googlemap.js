<script>
function initMap() {

    var latitude = document.getElementById('lat').value;
    var longitude = document.getElementById('lon').value;

    var pos = {lat: latitude, lng: longitude};AIzaSyBgsJCbKDGTcCxn7UfQrjxEI8bPyjpllZg

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 4,
        center: pos
    });
    var marker = new google.maps.Marker({
        position: pos,
        map: map
    });
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC5g3lROuua5hCO4WwJSwDXEPqaogMawVU&callback=initMap"
async defer>
</script>

