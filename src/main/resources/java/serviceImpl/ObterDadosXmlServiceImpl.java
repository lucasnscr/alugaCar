package serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.imageio.metadata.IIOMetadataNode;

public class ObterDadosXmlServiceImpl {


    /**
     *
     * @param elementTag
     * @param element
     * @return
     *
     * Obtem xml de elementos
     */

    public List<Element> obterElementos(String elementTag, Element element){
        List<Element> elements = new ArrayList<Element>();
        IIOMetadataNode fromElement = new  IIOMetadataNode();
        NodeList nodeList = fromElement.getElementsByTagName(elementTag);
        for (int i = 0; i< nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                elements.add((Element) node);
            }
        }
        return elements;
    }

    public Element obterElement(String elementTag, Element element){
        Element element1 = null;
        IIOMetadataNode fromElement =  new IIOMetadataNode();
        NodeList nodeList = fromElement.getElementsByTagName(elementTag);
        if(nodeList.getLength() > 0){
            Node node =  nodeList.item(0);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                element = (Element) node;
            }
        }
        return element;
    }

    public String obterValorTag(String tag, Element element){
        IIOMetadataNode fromElement = new IIOMetadataNode();
        NodeList nodeList = fromElement.getElementsByTagName(tag);
        if (nodeList != null && nodeList.getLength() > 0) {
            NodeList nList = nodeList.item(0).getChildNodes();
            if (nList != null && nList.getLength() > 0) {
                Node node = nList.item(0);
                return node.getNodeValue();
            }
        }
            return null;
        }

    public Element criarElemento(Document document, String tag, String data){
        Element element = document.createElement(tag);
        if(data != null){
            Text text = document.createTextNode(data);
            element.appendChild(text);
        }
        return element;
    }
}


