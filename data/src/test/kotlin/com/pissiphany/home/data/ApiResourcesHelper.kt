package com.pissiphany.home.data

import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

/**
 * Created by kierse on 2016-09-05.
 */
fun getApiResources() : Pair<String, String> {
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
            File("src/main/res/values/service.xml")
    )

    val xpath = XPathFactory.newInstance().newXPath()
    val root = xpath.evaluate("/resources/string[@name='themis_api_v2_root']", doc, XPathConstants.NODE) as Node
    val token = xpath.evaluate("/resources/string[@name='themis_api_oauth_token']", doc, XPathConstants.NODE) as Node

    return Pair(root.textContent, token.textContent)
}
