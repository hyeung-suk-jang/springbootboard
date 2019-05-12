package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.demo.mybatis.model.BoardVO;

@Component("statXls")
public class StatXlsView extends AbstractXlsView {

    @Override

    protected void buildExcelDocument(

            Map<String, Object> model, Workbook workbook,

            HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"board.xls\"");



        List<BoardVO> stats = (List<BoardVO>) model.get("list");



        CellStyle numberCellStyle = workbook.createCellStyle();

        DataFormat numberDataFormat = workbook.createDataFormat();

        numberCellStyle.setDataFormat(numberDataFormat.getFormat("#,##0"));


        Sheet sheet = workbook.createSheet("board");

        for (int i = 0 ; i < stats.size() ; i++) {

        	BoardVO stat = stats.get(i);

            Row row = sheet.createRow(i);



            Cell cell0 = row.createCell(0);

            cell0.setCellValue(stat.getBoardidx());



            Cell cell1 = row.createCell(1);

            cell1.setCellType(CellType.STRING);

            cell1.setCellValue(stat.getTitle());

            cell1.setCellStyle(numberCellStyle);



            Cell cell2 = row.createCell(2);

            cell2.setCellType(CellType.STRING);

            cell2.setCellValue(stat.getWriter());

            cell2.setCellStyle(numberCellStyle);

        }

    }

}