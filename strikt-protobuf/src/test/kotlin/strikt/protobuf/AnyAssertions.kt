package strikt.protobuf

import com.google.protobuf.Any
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import rpg.Character
import rpg.Role
import rpg.Sword
import strikt.api.expect

@DisplayName("assertions on com.google.protobuf.Any")
class AnyAssertions {

  @Test
  fun `can assert that an Any field is empty`() {
    val subject = Character
      .newBuilder()
      .apply {
        name = "Crom"
        role = Role.warrior
      }
      .build()

    expect(subject).map(Character::getWeapon).isEmpty()
  }

  @Test
  fun `can assert that an Any field is a particular type`() {
    val subject = Character
      .newBuilder()
      .apply {
        name = "Crom"
        role = Role.warrior
        weapon = Any.pack(Sword.newBuilder().setDamage("1d10").build())
      }
      .build()

    expect(subject).map(Character::getWeapon).unpacksTo<Sword>()
  }
}
