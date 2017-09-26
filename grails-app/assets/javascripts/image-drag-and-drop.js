function checkDrag(event) {
    event.preventDefault();
}

function doDrop(event) {
    event.preventDefault();

    var files = event.dataTransfer.files;

    for (var i = 0; i < files.length; i++) {
        var reader = new FileReader();
        reader.onload = function (e) {

            // previsualiser l'image
            var image = new Image();
            image.src = e.target.result;
            image.width = 300;
            var preview = document.getElementById('preview');
            preview.appendChild(image);
        }
        reader.readAsDataURL(files[i]);
    }
}