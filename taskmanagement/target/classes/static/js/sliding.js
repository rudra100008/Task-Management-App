function toggleNavbar() {
    const navbar = document.querySelector('nav.vertical');
    const body = document.body;
    navbar.classList.toggle('open');
    body.classList.toggle('navbar-open');
}