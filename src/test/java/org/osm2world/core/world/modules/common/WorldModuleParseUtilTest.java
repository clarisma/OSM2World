package org.osm2world.core.world.modules.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.osm2world.core.map_data.data.Tag;
import org.osm2world.core.map_data.data.TagGroup;

public class WorldModuleParseUtilTest {

	@Test
	public void testInheritTags() {

		TagGroup ownTags = TagGroup.of(
				new Tag("key0", "valA"),
				new Tag("key1", "valB"));

		TagGroup parentTags = TagGroup.of(
				new Tag("key1", "valX"),
				new Tag("key2", "valY"));

		TagGroup result = WorldModuleParseUtil.inheritTags(ownTags, parentTags);

		assertEquals(3, result.size());
		assertEquals("valA", result.getValue("key0"));
		assertEquals("valB", result.getValue("key1"));
		assertEquals("valY", result.getValue("key2"));

	}

}
