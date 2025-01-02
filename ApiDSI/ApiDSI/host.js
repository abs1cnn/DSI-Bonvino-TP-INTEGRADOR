
const express = require('express'); const fs = require('fs');

const app = express();

app.get('/Bodega-Los-Andes', (req, res) => { fs.readFile('./bdd_los_andes.json', 'utf8', (err, data) => { if (err) { console.error(err); res.status(500).send('Internal Server Error'); }
else { const jsonData = JSON.parse(data); res.json(jsonData); } }); });

app.get('/Bodega-1', (req, res) => { fs.readFile('./bdd1.json', 'utf8', (err, data) => { if (err) { console.error(err); res.status(500).send('Internal Server Error'); }
else { const jsonData = JSON.parse(data); res.json(jsonData); } }); });

app.get('/Bodega-2', (req, res) => { fs.readFile('./bdd1.json', 'utf8', (err, data) => { if (err) { console.error(err); res.status(500).send('Internal Server Error'); }
else { const jsonData = JSON.parse(data); res.json(jsonData); } }); });

app.listen(8080, () => { console.log('Server is running on port 8080'); });