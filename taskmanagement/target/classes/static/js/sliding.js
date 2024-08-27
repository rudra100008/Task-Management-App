function toggleNavbar() {
    const verticalNavbar = document.querySelector('nav.vertical');
    const mainContent=document.querySelector('.main-content');
    const body = document.body;

    verticalNavbar.classList.toggle('open');
    body.classList.toggle('navbar-open');

    if (verticalNavbar.classList.contains('open')) {
        mainContent.style.marginLeft='100px';
    } else {
        mainContent.style.marginLeft='200px';
    }
}
