#!/usr/bin/env node
const fs = require('fs')

let migrationName = process.argv[2].replaceAll(" ", "_");

const timestamp = new Date().toISOString().slice(0, 19).replace(/[^0-9]/g, "")

const fileName = `backend/src/main/resources/db/migration/V${timestamp}__${migrationName}.sql`
fs.openSync(fileName, 'w')
console.log('Created migration: ', fileName)