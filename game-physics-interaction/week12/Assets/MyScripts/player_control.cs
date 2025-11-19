using UnityEngine;

public class player_control : MonoBehaviour
{
    private void Update()
    {
        transform.Translate(new Vector3(0.0f, 0.0f, 3.0f * Time.deltaTime));
    }
}
