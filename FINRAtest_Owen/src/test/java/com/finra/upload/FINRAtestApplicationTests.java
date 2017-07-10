package com.finra.upload;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.finra.upload.FINRAtestApplication;
import com.finra.upload.controller.FileController;
import com.finra.upload.entity.FileInfo;
import com.finra.upload.service.FileInfoService;
import com.finra.upload.service.FileService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =FINRAtestApplication.class)
@WebAppConfiguration
public class FINRAtestApplicationTests {
	
	private MockMvc mockMvc;
	
	@MockBean
	private FileInfoService fileInfoService;
	
	@MockBean
	private FileService fileService;
	
	@InjectMocks
	private FileController fileController;
	
	@SuppressWarnings("deprecation")
	private long longDate = Date.UTC(2010, 1, 1, 20, 20, 20);
	
	private Date date = new Date(longDate);
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
	}
	
	@Test
	public void testUploadFile() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "test".getBytes());
		when(fileService.uploadFile(file, 1, longDate)).thenReturn("Succeed to Upload File");
		
	}
	
	@Test
	public void testDownloadFile() throws Exception {
		when(fileService.downloadFile(1, new MockHttpServletResponse(), new MockHttpServletRequest())).thenReturn("Fail to DownloadFile");
	}
	
	@Test
	public void testGetFileInfoById() throws Exception {
		FileInfo fileInfo = new FileInfo(1, "Owen.txt", (long) 200, date, "F:\\temp\\Owen.txt", "Owen");
				
		when(fileInfoService.getFileInfoById(1)).thenReturn(fileInfo);
		
		mockMvc.perform(get("/getFileById/{id}", 1))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.name", is("Owen.txt")))
			.andExpect(jsonPath("$.size", is(200)))
//			.andExpect(jsonPath("$.date", is("2010-01-01 20:20:20")))
			.andExpect(jsonPath("$.path", is("F:\\temp\\Owen.txt")))
			.andExpect(jsonPath("$.author", is("Owen")));
		
	}
	
	@Test
	public void testGetFileInfoByName() throws Exception {		
		List<FileInfo> fileInfoList = new ArrayList<>();
		fileInfoList.add(new FileInfo(1, "Owen.txt", (long) 200, date, "F:\\temp\\Owen.txt", "Owen"));
		fileInfoList.add(new FileInfo(2, "Owen.gif", (long) 100, date, "F:\\temp\\Owen.gif", "Liu"));
		
		when(fileInfoService.getFileInfoByName("Owen")).thenReturn(fileInfoList);
		
		mockMvc.perform(get("/getFileByName/{name}", "Owen"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Owen.txt")))
			.andExpect(jsonPath("$[0].size", is(200)))
			.andExpect(jsonPath("$[0].path", is("F:\\temp\\Owen.txt")))
			.andExpect(jsonPath("$[0].author", is("Owen")))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Owen.gif")))
			.andExpect(jsonPath("$[1].size", is(100)))
			.andExpect(jsonPath("$[1].path", is("F:\\temp\\Owen.gif")))
			.andExpect(jsonPath("$[1].author", is("Liu")));
	}
	
	@Test
	public void testGetFileInfoList() throws Exception {	
		List<FileInfo> fileInfoList = new ArrayList<>();
		fileInfoList.add(new FileInfo(1, "Owen.txt", (long) 200, date, "F:\\temp\\Owen.txt", "Owen"));
		fileInfoList.add(new FileInfo(2, "Owen.gif", (long) 100, date, "F:\\temp\\Owen.gif", "Liu"));
		
		when(fileInfoService.getFileInfoList()).thenReturn(fileInfoList);
		
		mockMvc.perform(get("/getFileList"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Owen.txt")))
			.andExpect(jsonPath("$[0].size", is(200)))
			.andExpect(jsonPath("$[0].path", is("F:\\temp\\Owen.txt")))
			.andExpect(jsonPath("$[0].author", is("Owen")))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Owen.gif")))
			.andExpect(jsonPath("$[1].size", is(100)))
			.andExpect(jsonPath("$[1].path", is("F:\\temp\\Owen.gif")))
			.andExpect(jsonPath("$[1].author", is("Liu")));
	}
}
