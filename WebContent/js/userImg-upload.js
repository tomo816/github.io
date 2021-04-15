/**
 *
 */


$('#iconUrl').on('change', function (e) {
    var reader = new FileReader();
    reader.onload = function (e) {
        $(".preview").attr('src', e.target.result);
         $(".preview").attr('value', e.target.result);
    }
    reader.readAsDataURL(e.target.files[0]);
});