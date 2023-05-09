// $(function () {
//     $('#keyword').keypress(function (e) {
//         var key = e.which; //e.which是按键的值
//         if (key == 13) {
//             var q = $(this).val();
//             if (q && q != '') {
//                 window.location.href = '/search?keyword=' + q;
//             }
//         }
//     });
// });
//
// function search() {
//     var q = $('#keyword').val();
//     if (q && q != '') {
//         window.location.href = '/search?keyword=' + q;
//     }
// }
const categories = document.querySelectorAll('.category input[type="checkbox"]');

for (let i = 0; i < categories.length; i++) {
    categories[i].addEventListener('change', function() {
        const subcategory = this.nextElementSibling;
        if (subcategory) {
            if (this.checked) {
                subcategory.style.display = 'flex';
            } else {
                subcategory.style.display = 'none';
            }
        }
    });
}
