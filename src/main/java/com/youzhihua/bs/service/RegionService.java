package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.RegionMapper;
import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.PinYin4jUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionMapper regionMapper;

    public void impotRrgion(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        int i = 0;
        for (Row rows : sheetAt) {
            if (i == 0) {
                i++;
                continue;
            }
            String id = rows.getCell(0).getStringCellValue();
            String province = rows.getCell(1).getStringCellValue();
            String city = rows.getCell(2).getStringCellValue();
            String district = rows.getCell(3).getStringCellValue();
            String postcode = rows.getCell(4).getStringCellValue();
            Region region = new Region(id, province, city, district, postcode, null, null);
            province = province.substring(0, province.length() - 1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);
            String info = province + city + district;
            String[] headByString = PinYin4jUtils.getHeadByString(info);
            String shortCode = StringUtils.join(headByString);
            String cityCode = PinYin4jUtils.hanziToPinyin(city, "");
            region.setCitycode(cityCode);
            region.setShortcode(shortCode);
            regionMapper.insert(region);

        }

    }

    public PageBean<Region> findItemByPage(int page, int rows) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(page, rows);

        List<Region> allItems = regionMapper.selectAll();        //全部商品
        int countNums = regionMapper.countItem();            //总记录数
        PageBean<Region> pageData = new PageBean<>(page, rows, countNums);
        pageData.setRows(allItems);
        return pageData;
    }

    public List<Region> findAll() {
        return regionMapper.selectAll();
    }
}
