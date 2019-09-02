package com.hshbic.ai.common.utils.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 邮件内容模板生产工厂类
 *
 * @Description:
 * @project mailUtil
 */
public class TemplateFactory {
	// 日志记录对象
	private static Logger log = LoggerFactory.getLogger(TemplateFactory.class);
	// 模板文件路径
	private static String templatePath = "classpath:/templates/";
	// 模板文件内容编码
	private static final String ENCODING = "utf-8";
	// 模板生成配置
	@SuppressWarnings("deprecation")
	private static Configuration conf = new Configuration();
	// 邮件模板缓存池
	private static Map<String, Template> tempMap = new HashMap<>();
	static {
		// 设置模板文件路径
		conf.setClassForTemplateLoading(TemplateFactory.class, templatePath);
	}

	/**
	 * 通过模板文件名称获取指定模板
	 *
	 * @param name
	 *            模板文件名称
	 * @return Template 模板对象
	 * @throws IOException
	 * @Description:
	 * @return Template
	 */
	private static Template getTemplateByName(String name) throws IOException {
		if (tempMap.containsKey(name)) {
			log.debug("the template is already exist in the map,template name :"
					+ name);
			// 缓存中有该模板直接返回
			return tempMap.get(name);
		}
		// 缓存中没有该模板时，生成新模板并放入缓存中
		Template temp = conf.getTemplate(name);
		tempMap.put(name, temp);
		log.debug("the template is not found  in the map,template name :"
				+ name);
		return temp;
	}


	/**
	 *
	 * @param name
	 *            模板文件的名称
	 * @param map
	 *            与模板内容转换对象
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 * @Description:
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String generateHtmlFromFtl(String name,
			Map<String, String> map) throws IOException, TemplateException {
		Writer out = new StringWriter(2048);
		Template temp = getTemplateByName(name);
		temp.setEncoding(ENCODING);
		temp.process(map, out);
		return out.toString();
	}
}
