const $btnExportar = document.querySelector("#btnExportar"),
        $tabla = document.querySelector("#tabla");
        $btnExportar.addEventListener("click", function() {
    let tableExport = new TableExport($tabla, {
        exportButtons: false, // No queremos botones
        filename: "schedule_dwd", //Nombre del archivo de Excel
        sheetname: "schedule", //Título de la hoja
        formats: ["xlsx", "csv", "txt"], 
    });
    let datos = tableExport.getExportData();
    let preferenciasDocumento = datos.tabla.xlsx;
    tableExport.export2file(preferenciasDocumento.data, preferenciasDocumento.mimeType, preferenciasDocumento.filename, preferenciasDocumento.fileExtension, preferenciasDocumento.merges, preferenciasDocumento.RTL, preferenciasDocumento.sheetname);
    });