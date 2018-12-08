package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.Node;

public class Day8Part1Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseNodes() throws URISyntaxException {
		int expectedNumberOfNodes = 4;
		int expectedNumberOfMetadata = 8;
		int expectedMetadataSum = 138;

		List<Node> nodes = Day8Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day8TestInput.txt").toURI()));

		assertEquals(expectedNumberOfNodes, nodes.size());
		assertEquals(expectedNumberOfMetadata, nodes.stream().mapToInt(node -> node.getMetadata().size()).sum());
		assertEquals(expectedMetadataSum, Day8Part1.getMetadataSum(nodes));
	}

}
