const API_URL = 'http://localhost:8080/api/mobil';

// Fetch and display all mobils
async function fetchMobils() {
    try {
        const response = await fetch(API_URL);
        const mobils = await response.json();
        displayMobils(mobils);
    } catch (error) {
        console.error('Error:', error);
    }
}

// Display mobils in the table
function displayMobils(mobils) {
    const tbody = document.querySelector('.listMobil tbody');
    tbody.innerHTML = '';
    
    mobils.forEach((mobil, index) => {
        const row = `
            <tr>
                <td>${index + 1}</td>
                <td>${mobil.nama}</td>
                <td>${mobil.noRangka}</td>
                <td>${mobil.noMesin}</td>
                <td>${mobil.platNomor}</td>
                <td>${mobil.kapasitasMesin}</td>
                <td>${mobil.jenis}</td>
                <td>Rp ${formatNumber(mobil.harga)}</td>
                <td>
                    <button class="btn-edit" onclick="editMobil(${mobil.id})">Edit</button>
                    <button class="btn-delete" onclick="deleteMobil(${mobil.id})">Delete</button>
                </td>
            </tr>
        `;
        tbody.innerHTML += row;
    });
}

// Delete mobil
async function deleteMobil(id) {
    if (confirm('Are you sure you want to delete this car?')) {
        try {
            const response = await fetch(`${API_URL}/${id}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                fetchMobils(); // Refresh the list
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

// Format number to currency
function formatNumber(number) {
    return new Intl.NumberFormat('id-ID').format(number);
}

// Add mobil form handler
async function addMobil(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const mobilData = Object.fromEntries(formData.entries());

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(mobilData)
        });
        
        if (response.ok) {
            fetchMobils();
            closeModal();
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

// Edit mobil
async function editMobil(id) {
    try {
        const response = await fetch(`${API_URL}/${id}`);
        const mobil = await response.json();
        openEditModal(mobil);
    } catch (error) {
        console.error('Error:', error);
    }
}

// Update mobil
async function updateMobil(id, mobilData) {
    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(mobilData)
        });
        
        if (response.ok) {
            fetchMobils();
            closeModal();
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

// Search functionality
document.querySelector('input[name="searchM"]').addEventListener('input', async (e) => {
    const searchTerm = e.target.value.toLowerCase();
    const response = await fetch(API_URL);
    const mobils = await response.json();
    
    const filteredMobils = mobils.filter(mobil => 
        mobil.nama.toLowerCase().includes(searchTerm) ||
        mobil.noRangka.toLowerCase().includes(searchTerm) ||
        mobil.platNomor.toLowerCase().includes(searchTerm)
    );
    
    displayMobils(filteredMobils);
});

// Load mobils when page loads
document.addEventListener('DOMContentLoaded', fetchMobils);