const inicial = ([{ id: 1, urlImg: "imagesJuegos/alan.jpg", titulo: "Alan Wake 2", precio: (~~(Math.random() * 100000)), genero: "Acción" },
{ id: 2, urlImg: "imagesJuegos/brave.jpg", titulo: "Brave", precio: (~~(Math.random() * 100000)), genero: "Aventuras" },
{ id: 3, urlImg: "imagesJuegos/duty.jpeg", titulo: "Call of Duty: Black Ops II", precio: (~~(Math.random() * 100000)), genero: "Multijugador" },
{ id: 4, urlImg: "imagesJuegos/fallout.jpg", titulo: "Fallout 4 (GOTY)", precio: (~~(Math.random() * 100000)), genero: "RPG" },
{ id: 5, urlImg: "imagesJuegos/final.jpg", titulo: "Lightning Returns: Final Fantasy XIII", precio: (~~(Math.random() * 100000)), genero: "RPG" },
{ id: 6, urlImg: "imagesJuegos/lego.jpg", titulo: "LEGO: Marvel Super Heroes ", precio: (~~(Math.random() * 100000)), genero: "Plataformas" },
{ id: 7, urlImg: "imagesJuegos/lies.jpg", titulo: "Lies of P ", precio: (~~(Math.random() * 100000)), genero: "Acción" },
{ id: 8, urlImg: "imagesJuegos/metro.jpeg", titulo: "Metro Exodus", precio: (~~(Math.random() * 100000)), genero: "Aventuras" },
{ id: 9, urlImg: "imagesJuegos/minecraft.jpeg", titulo: "Minecraft: Java Edition", precio: (~~(Math.random() * 100000)), genero: "Multijugador" },
{ id: 10, urlImg: "imagesJuegos/mortal.jpg", titulo: "Mortal Kombat X", precio: (~~(Math.random() * 100000)), genero: "Plataformas" },
{ id: 11, urlImg: "imagesJuegos/no_man.jpg", titulo: "No Man's Sky", precio: (~~(Math.random() * 100000)), genero: "Multijugador" },
{ id: 12, urlImg: "imagesJuegos/party.jpg", titulo: "Party Animals", precio: (~~(Math.random() * 100000)), genero: "Acción" },
{ id: 13, urlImg: "imagesJuegos/persona.jpg", titulo: "Persona 5 Royal ", precio: (~~(Math.random() * 100000)), genero: "Aventuras" },
{ id: 14, urlImg: "imagesJuegos/plague.jpeg", titulo: "A Plague Tale: Innocence", precio: (~~(Math.random() * 100000)), genero: "Horror" },
{ id: 15, urlImg: "imagesJuegos/resident.jpeg", titulo: "Resident Evil 4 (2005)", precio: (~~(Math.random() * 100000)), genero: "Horror" },
{ id: 16, urlImg: "imagesJuegos/resident6.jpeg", titulo: "Resident Evil 6", precio: (~~(Math.random() * 100000)), genero: "Horror" },
{ id: 17, urlImg: "imagesJuegos/street.jpg", titulo: "Street Fighter 6 Deluxe Edition", precio: (~~(Math.random() * 100000)), genero: "Lucha" },
{ id: 18, urlImg: "imagesJuegos/witcher.jpg", titulo: "The Witcher 3: Wild Hunt", precio: (~~(Math.random() * 100000)), genero: "RPG" }
])

let catalogo = inicial

let cards = document.getElementById("cards")


function showCard() {
    let i = 0
    catalogo.forEach(c => {
        cards.innerHTML += `<div class="card" id="card${i}">
    <img id="imagen" src="${c.urlImg}" alt="">
    <hr>
    <div class="ti">
        <p id="titulo">${c.titulo}</p>
    </div>             
    <hr>
    <div class="inferior">
        <p id="precio">$${c.precio}</p>
        <img src="images/anadir-al-carrito (1).png" alt="" id="${c.id}" onclick="cantidadCarrito(${c.id})">
    </div>
</div>`
    })
}

function todosCard() {
    let load = aleatorio()
    cards.innerHTML = `
        <img src="images/loading-${load}.gif" alt="" id="load">
        `;
    setTimeout(function () {
        let i = 0
        cards.innerHTML = ""
        catalogo.forEach(c => {
            cards.innerHTML += `<div class="card" id="card${i}">
    <img id="imagen" src="${c.urlImg}" alt="">
    <hr>
    <div class="ti">
        <p id="titulo">${c.titulo}</p>
    </div>             
    <hr>
    <div class="inferior">
        <p id="precio">$${c.precio}</p>
        <img src="images/anadir-al-carrito (1).png" alt="" id="${c.id}" onclick="cantidadCarrito(${c.id})"">
    </div>
</div>`
            i++
        })
    }, 2000);
}


let acc = document.getElementById("acc")
let aven = document.getElementById("aven")
let horr = document.getElementById("horr")
let lu = document.getElementById("lu")
let mul = document.getElementById("mul")
let pla = document.getElementById("pla")
let rpg = document.getElementById("rpg")
let tod = document.getElementById("tod")

function showCant(name, id) {
    let i = 0
    let j = 0

    while (i < catalogo.length) {
        if (catalogo[i].genero == name) {
            j++
        }
        i++
    }


    switch (id) {
        case "acc":
            acc.innerHTML = j
            break
        case "aven":
            aven.innerHTML = j
            break
        case "horr":
            horr.innerHTML = j
            break
        case "lu":
            lu.innerHTML = j
            break
        case "mul":
            mul.innerHTML = j
            break
        case "pla":
            pla.innerHTML = j
            break
        case "rpg":
            rpg.innerHTML = j
            break
        case "tod":
            tod.innerHTML = i
        default:
            break
    }
}

function accionCard(a) {
    let i = 0
    let load = aleatorio()
    cards.innerHTML = `
        <img src="images/loading-${load}.gif" alt="" id="load">
        `;

    setTimeout(function () {
        cards.innerHTML = ""
        while (i < catalogo.length) {
            if (catalogo[i].genero == a) {
                cards.innerHTML += `<div class="card" id="card${i}">
                    <img id="imagen" src="${catalogo[i].urlImg}" alt="">
                    <hr>
                    <div class="ti">
                    <p id="titulo">${catalogo[i].titulo}</p>
                    </div>             
                    <hr>
                    <div class="inferior">
                    <p id="precio">$${catalogo[i].precio}</p>
                    <img src="images/anadir-al-carrito (1).png" alt="" id="${catalogo[i].id}" onclick="cantidadCarrito(${catalogo[i].id})">
                    </div>
                    </div>`
            }
            i++
        }
    }, 2000);
}

let carrito = document.getElementById("carrito")
let carri = document.getElementById("carri")
function showCarrito() {
    carrito.classList.toggle("showCarrito")
}

function aleatorio() {
    return Math.round(Math.random() * (2 - 1) + 1);
}

let cant = document.getElementById("cantCarrito")
function inicioCarr() {
    let c = 0
    cant.innerHTML = c
}
let ca = 0


function cantidadCarrito(id) {
    ca++
    cant.innerHTML = ca
    let a = `cardCa${id}`
    if (document.getElementById(a)) {
        editarCarrito(id)
    } else {
        agregarCarrito(id)
    }
    sumarCarrito(id)
}

function editarCarrito(id) {
    let a = document.getElementById(`cantidadCard${id}`).value
    a++
    document.getElementById(`cantidadCard${id}`).value = a
    let b = document.getElementById(`precio${id}`).innerHTML
    let c = 0
    c = parseInt(b, 10)
    let d = parseInt(catalogo[id - 1].precio, 10)
    c += d
    document.getElementById(`precio${id}`).innerHTML = c
}

let cardsCa = document.getElementById("cardsCa")

function agregarCarrito(id) {
    let i = 0
    while (i < catalogo.length) {
        if (catalogo[i].id == id) {
            /* cardsCa.innerHTML += `<div class="cardCa" id="cardCa${id}">
            <img id="imagen" src="${catalogo[i].urlImg}" alt="">
            <div class="derecha">
                <p id="titulo">${catalogo[i].titulo}</p>
                <hr>
                <div class="inferiorCa">
                    <p id="precio">$<span id="precio${id}">${catalogo[i].precio}</span></p>
                    <span class="material-symbols-outlined" onclick="quitarCard()">
                        cancel
                    </span>
                    <p id="cant">Cantidad: <input type="number" class="inputCard" id="cantidadCard${id}" /></p>
                </div>
            </div>
        </div>` */
            const cardCa = document.createElement("div")
            cardCa.classList.add("cardCa")
            cardCa.setAttribute("id", `cardCa${id}`)
            const img = document.createElement("img")
            img.setAttribute("id", "imagen")
            img.setAttribute("src", `${catalogo[i].urlImg}`)
            const derecha = document.createElement("div")
            derecha.classList.add("derecha")
            const parrafo1 = document.createElement("p")
            parrafo1.setAttribute("id", "titulo")
            parrafo1.innerHTML = `${catalogo[i].titulo}`
            const linea = document.createElement("hr")
            const inferiorCa = document.createElement("div")
            inferiorCa.classList.add("inferiorCa")
            const parrafo2 = document.createElement("p")
            parrafo2.setAttribute("id", "precio")
            parrafo2.innerHTML = "$"
            const span1 = document.createElement("span")
            span1.setAttribute("id", `precio${id}`)
            span1.innerHTML = `${catalogo[i].precio}`
            const span2 = document.createElement("span")
            span2.classList.add("material-symbols-outlined")
            span2.setAttribute("onclick", `quitarCard(${i},${id})`)
            span2.innerHTML = "cancel"
            const parrafo3 = document.createElement("p")
            parrafo3.setAttribute("id", "cant")
            parrafo3.innerHTML = "Cantidad: "
            const input = document.createElement("input")
            input.classList.add("inputCard")
            input.setAttribute("type", "number")
            input.setAttribute("onchange", `valorInput(${i},${id})`)
            input.setAttribute("id", `cantidadCard${id}`)
            input.setAttribute("min", "0")
            input.setAttribute("max", "15")
            input.setAttribute("value", "1")

            parrafo2.appendChild(span1)
            inferiorCa.appendChild(parrafo2)
            inferiorCa.appendChild(span2)
            parrafo3.appendChild(input)
            inferiorCa.appendChild(parrafo3)

            derecha.appendChild(parrafo1)
            derecha.appendChild(linea)
            derecha.appendChild(inferiorCa)

            cardCa.appendChild(img)
            cardCa.appendChild(derecha)

            cardsCa.appendChild(cardCa)
            break
        }
        i++
    }
}

function valorInput(i, id) {
    let a = parseInt(catalogo[i].precio, 10)
    let b = parseInt(document.getElementById(`cantidadCard${id}`).value, 10)
    let d = a * b
    let c = document.getElementById(`precio${id}`).innerHTML
    let e = parseInt(c)
    document.getElementById(`precio${id}`).innerHTML = d

    let q = document.getElementById(`precio${id}`).innerHTML
    let w = parseInt(q, 10)
    console.log(w)
    console.log(e)
    if (w > c) {
        ca++
        cant.innerHTML = ca
        tot += parseInt(catalogo[i].precio, 10)
        total.innerHTML = `$${tot}`
    } else {
        ca--
        cant.innerHTML = ca
        tot -= parseInt(catalogo[i].precio, 10)
        total.innerHTML = `$${tot}`
    }

    if (b == "0") {
        quitarCard(i, id)
    }
}

function quitarCard(i, id) {
    let a = document.getElementById(`cardCa${id}`)
    let b = document.getElementById(`precio${id}`).innerHTML
    let c = document.getElementById(`cantidadCard${id}`).value
    cardsCa.removeChild(a)
    tot -= parseInt(b)
    total.innerHTML = `$${tot}`
    ca -= parseInt(c)
    cant.innerHTML = ca
}

let total = document.getElementById("total")
let tot = 0
total.innerHTML = tot
function sumarCarrito(id) {
    let i = 0
    while (i < catalogo.length) {
        if (catalogo[i].id == id) {
            tot += parseInt(catalogo[i].precio, 10)
            total.innerHTML = `$${tot}`
            break
        }
        i++
    }
}

let cerrar = document.getElementById("close")

function cerrarCarrito() {
    carrito.classList.toggle("showCarrito")
}

