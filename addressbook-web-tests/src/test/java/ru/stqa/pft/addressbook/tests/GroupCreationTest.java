package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Groups before = app.Group().All();
    GroupData group = new GroupData().withName("test2");
    app.Group().create(group);
    assertThat(app.Group().Count(), equalTo(before.size() + 1));
    Groups after = app.Group().All();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() {
    app.goTo().GroupPage();
    Groups before = app.Group().All();
    GroupData group = new GroupData().withName("test'");
    app.Group().create(group);
    assertThat(app.Group().Count(), equalTo(before.size()));
    Groups after = app.Group().All();

    assertThat(after, equalTo(before));
  }
}
